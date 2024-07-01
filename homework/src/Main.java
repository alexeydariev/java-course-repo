import Student.example.chat.entities.User;
import Student.example.chat.services.AuthService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.StringWriter;
import java.util.Date;

public class Main {
    public static void main(String[] args)throws Exception {
        AuthService authService = new AuthService();
        //IdentificationService identificationService = new IdentificationService();
        int userCount = 0;
        while(userCount < 10) {
            User user = new User("johny" + userCount,
                    "123", new Date(), 'm', "jh" + userCount + "@e.h");
            authService.signUp(user);
            userCount++;
        }

        User user = new User("sasi",
                "123", (new Date()), 'm', "jh@e.h");
        authService.signUp(user);
        //System.out.println(authService.srchUsr(user) + "AAAA");
        //authService.signUp(user);
        System.out.println(authService.getUsers());
        authService.dropOut(user);
        System.err.println(authService.getUsers());
        //System.out.println(authService.getUsers());

        /*
        ObjectWriter jsonMapper = new ObjectMapper().writer().withDefaultPrettyPrinter();
        XmlMapper xmlMapper = new XmlMapper();
        YAMLMapper yamlMapper = new YAMLMapper();

        System.out.println(jsonMapper.writeValueAsString(user));
        System.out.println(xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
        System.out.println(yamlMapper.writeValueAsString(user));
        */


        //authService.signUp(user);
        //authService.signUp(user);
        //System.out.println(user);


        //System.out.println(authService.encryptUserPassword(user));

        //System.out.println(Arrays.toString(authService.getUsers()));

        //authService.setUsers();

        /*
        System.out.println(authService.srchUsr(user));

        authService.dropOut(user);
        //
        System.out.println(Arrays.toString(authService.getUsers()));
        authService.dropOut(authService.getUsers()[1]);
        System.out.println(Arrays.toString(authService.getUsers()));

        //String [] chars = {null, null, null};
        //System.out.println(chars.length-1);
        //System.out.println(Long.MAX_VALUE);
        //User user =  new User(123, "johny", "123", new Date(), 'm', "jh@e.h");
        //ser user1 =  new User(123, "johny", "123", new Date(), 'm', "jh@e.h");

        //authService.signUp(user);
        //authService.signUp(user1);


        ///authService.dropOut(user1);
        */
    }
}