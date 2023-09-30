package ismael.rosas.api.todolist.models.user;

import ismael.rosas.api.todolist.models.task.Task;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperUser {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true);
    }

    public static ResponseUser EntityToResponse(User user) {
        return modelMapper.map(user, ResponseUser.class);
    }
    public static RequestUsers EntityToRequest(User user) {
        return modelMapper.map(user, RequestUsers.class);
    }

    public static User ResponseToEntity(ResponseUser responseUser) {
        return modelMapper.map(responseUser, User.class);
    }

    public static User RequestToEntity(RequestUsers requestUsers) {
        return modelMapper.map(requestUsers, User.class);
    }

    public static List<ResponseUser> EntityToListResponse(List<User> listUser) {
        List<ResponseUser> responseUser = new ArrayList<>();
        listUser.forEach(user -> responseUser.add(EntityToResponse(user)));
        return responseUser;
    }


}
