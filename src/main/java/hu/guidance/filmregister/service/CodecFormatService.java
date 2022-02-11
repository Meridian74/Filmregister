package hu.guidance.filmregister.service;

import hu.guidance.filmregister.dto.CodecFormatDTO;
import hu.guidance.filmregister.dto.CreateCodecFormatCommand;
import hu.guidance.filmregister.dto.UpdateCodecFormatCommand;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface CodecFormatService {
    CodecFormatDTO createCodecFormat(CreateCodecFormatCommand command);

    CodecFormatDTO findCodecFormatById(long id);

    @Transactional
    CodecFormatDTO updateCodecFormat(long id, UpdateCodecFormatCommand command);

    void deleteCodecFormatById(long id);

    List<CodecFormatDTO> listAllCodecFormats(Optional<String> prefix);
}
