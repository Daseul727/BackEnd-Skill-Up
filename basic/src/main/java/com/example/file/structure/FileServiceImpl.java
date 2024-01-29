package com.example.file.structure;

import com.example.file.application.FileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.UUID;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Value("${file.upload.path}")
    private String FILE_UPLOAD_PATH;

    @Value("${file.upload.max-file-size}")
    private long MAX_FILE_SIZE;

    @Override
    public String saveThumbnailImage(String path, MultipartFile file) throws Exception {

        //저장경로 설정 ( /upload/ 어쩌고 + 커스텀 path)
        Path newPath = Path.of(FILE_UPLOAD_PATH + path);

        try {
            if (file.getSize() > MAX_FILE_SIZE) {
                throw new Exception("파일 크기가 허용된 크기를 초과했습니다. 최대 5MB까지 업로드 가능합니다.");
            }

            // 1. 폴더가 없으면 폴더 생성
            if (!Files.exists(newPath)) {
                Files.createDirectories(newPath);
            }

            // 2. new file name
            UUID uuid = UUID.randomUUID();
            String newFilename = uuid.toString();

            // 3. 저장경로 + new name
            newPath = newPath.resolve(newFilename + "." + getFileType(Objects.requireNonNull(file.getOriginalFilename())));

            // 4. 저장
            byte[] bytes = file.getBytes();
            Files.write(newPath, bytes);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("파일업로드에 실패하였습니다.");
        }

        String resultPath = newPath.toString();

        //5. 실제 저장경로 prefix 를 /upload/ 로 replace
        resultPath = resultPath.replace(FILE_UPLOAD_PATH,"/upload/");

        return resultPath;
    }

    // 파일 확장자 추출
    private String getFileType(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');
        if (lastDotIndex == -1) {
            return ""; // 확장자 없는 경우
        }
        return filename.substring(lastDotIndex + 1);
    }
}
