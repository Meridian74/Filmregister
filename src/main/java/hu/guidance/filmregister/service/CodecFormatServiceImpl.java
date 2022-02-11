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
        codecFormat.setName(command.getLanguage());

        codecFormat = codecFormatRepository.save(codecFormat);
        return modelMapper.map(codecFormat, CodecFormatDTO.class);

    }

    @Override
    public CodecFormatDTO findCodecFormatById(long id) {
        Optional<CodecFormat> optionalEmployee = codecFormatRepository.findById(id);

        if (optionalEmployee.isPresent()) {
            return modelMapper.map(optionalEmployee.get(), CodecFormatDTO.class);
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

        CodecFormat employee = optionalCodecFormat.get();
        if (command.getLanguage() != null && !command.getLanguage().equals("") ) {
            employee.setName(command.getLanguage());
        }

        return modelMapper.map(employee, CodecFormatDTO.class);
    }

    @Override
    public void deleteEmployeeById(long id) {
        Optional<CodecFormat> optionalEmployee = codecFormatRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            codecFormatRepository.deleteById(id);
        }
        else {
            throw new CodecFormatNotFoundException(id);
        }
    }

    @Override
    public List<CodecFormatDTO> listAllCodecFormats(Optional<String> prefix) {
        Type targetListType = new TypeToken<List<CodecFormatDTO>>(){}.getType();

        List<CodecFormat> employees = codecFormatRepository.findAll();
        List<CodecFormat> filtered = employees.stream()
                .filter(e -> prefix.isEmpty()
                        || e.getName().toLowerCase().startsWith(prefix.get().toLowerCase()))
                .collect(Collectors.toList());

        return modelMapper.map(filtered, targetListType);
    }

}
