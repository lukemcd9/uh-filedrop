package edu.hawaii.its.filedrop.repository;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.hawaii.its.filedrop.configuration.SpringBootWebApplication;
import edu.hawaii.its.filedrop.type.FileDrop;
import edu.hawaii.its.filedrop.type.Recipient;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { SpringBootWebApplication.class })
public class RecipientRepositoryTest {

    @Autowired
    private RecipientRepository recipientRepository;

    @Autowired
    private FileDropRepository fileDropRepository;

    @Test
    public void findRecipientsTest() {
        LocalDateTime created = LocalDateTime.now();
        LocalDateTime expiration = created.plus(10, ChronoUnit.DAYS);
        FileDrop fileDrop = new FileDrop();
        fileDrop.setId(9999);
        fileDrop.setUploader("test");
        fileDrop.setUploaderFullName("Test 123");
        fileDrop.setCreated(created);
        fileDrop.setExpiration(expiration);
        fileDrop.setDownloadKey("testdownloadkey");
        fileDrop.setUploadKey("testuploadkey");
        fileDrop.setEncryptionKey("testencryptionkey");
        fileDrop.setAuthenticationRequired(false);
        fileDrop.setValid(false);

        fileDrop = fileDropRepository.save(fileDrop);

        Recipient recipient = new Recipient();
        recipient.setId(4);
        recipient.setName("tester");
        recipient.setFileDrop(fileDrop);

        recipient = recipientRepository.save(recipient);

        assertEquals(1, recipientRepository.findAllByFileDrop(fileDrop).size());
        assertThat(recipientRepository.findAllByFileDrop(fileDrop).toString(), containsString("tester"));
        assertThat(recipient.getId(), equalTo(4));
        assertThat(recipient.getFileDrop().getId(), equalTo(fileDrop.getId()));

        fileDrop.setRecipients(null);
        fileDrop = fileDropRepository.save(fileDrop);

        assertNull(fileDrop.getRecipients());
    }

}
