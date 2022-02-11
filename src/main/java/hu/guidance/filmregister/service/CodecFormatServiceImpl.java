package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CodecFormatDTO;
import hu.guidance.filmregister.dto.CreateCodecFormatCommand;
import hu.guidance.filmregister.dto.UpdateCodecFormatCommand;
import hu.guidance.filmregister.exception.CodecFormatNotFoundException;
import hu.guidance.filmregister.model.CodecFormat;
import hu.guidance.filmregister.repository.CodecFormatRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CodecFormatServiceImpl implements CodecFormatService {

    private final CodecFormatRepository codecFormatRepository;
    private final ModelMapper modelMapper;

    public CodecFormatServiceImpl(CodecFormatRepository codecFormatRepository, ModelMapper modelMapper) {
        this.codecFormatRepository = codecFormatRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CodecFormatDTO createCodecFormat(CreateCodecFormatCommand command) {
        CodecFormat codecFormat = new CodecFormat();
        codecFormat.setName(command.getName());

        codecFormat = codecFormatRepository.save(codecFormat);
        return modelMapper.map(codecFormat, CodecFormatDTO.class);

    }

    @Override
    public CodecFormatDTO findCodecFormatById(long id) {
        Optional<CodecFormat> optionalCodecFormat = codecFormatRepository.findById(id);

        if (optionalCodecFormat.isPresent()) {
            return modelMapper.map(optionalCodecFormat.get(), CodecFormatDTO.class);
        }
        else {
            throw new CodecFormatNotFoundException(id);
        }
    }

    @Override
    @Transactional
    public CodecFormatDTO updateCodecFormat(long id, UpdateCodecFormatCommand command) {
        Optional<CodecFormat> optionalCodecFormat = codecFormatRepository.findById(id);

        if (optionalCodecFormat.isEmpty()) {
            throw new CodecFormatNotFoundException(id);
        }

        CodecFormat codecFormat = optionalCodecFormat.get();
        if (command.getName() != null && !command.getName().equals("") ) {
            codecFormat.setName(command.getName());
        }

        return modelMapper.map(codecFormat, CodecFormatDTO.class);
    }

    @Override
    public void deleteCodecFormatById(long id) {
        Optional<CodecFormat> optionalCodecFormat = codecFormatRepository.findById(id);
        if (optionalCodecFormat.isPresent()) {
            codecFormatRepository.deleteById(id);
        }
        else {
            throw new CodecFormatNotFoundException(id);
        }
    }

    @Override
    public List<CodecFormatDTO> listAllCodecFormats(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<CodecFormatDTO>>(){}.getType();

        List<CodecFormat> codecFormat = codecFormatRepository.findAll();
        List<CodecFormat> filtered = codecFormat.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }

}
