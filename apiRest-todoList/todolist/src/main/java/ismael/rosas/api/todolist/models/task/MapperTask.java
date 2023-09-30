package ismael.rosas.api.todolist.models.task;

import org.modelmapper.ModelMapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MapperTask {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration()
                .setSkipNullEnabled(true);
    }

    public static ResponseTask EntityToResponse(Task task) {

//        return modelMapper.map(task, ResponseTask.class);

        ResponseTask responseTask = new ResponseTask();
        copyFields(task, responseTask);
        return responseTask;
    }


    public static Task ResponseToEntity(ResponseTask responseTask) {
//        return modelMapper.map(responseTask, Task.class);
        Task task = new Task();
        copyFields(responseTask, task);
        return  task;
    }






    public static List<ResponseTask> EntityToListResponse(List<Task> listTask) {
        List<ResponseTask> responseTask = new ArrayList<>();
        listTask.forEach(task -> responseTask.add(EntityToResponse(task)));
        return responseTask;
    }


    public static void copyFields(Object source, Object destination) {
        Class<?> sourceClass = source.getClass();
        Class<?> destinationClass = destination.getClass();

        Field[] sourceFields = sourceClass.getDeclaredFields();

        for (Field sourceField : sourceFields) {
            try {
                Field destinationField = destinationClass.getDeclaredField(sourceField.getName());
                sourceField.setAccessible(true);
                destinationField.setAccessible(true);
                Object value = sourceField.get(source);
                System.out.println(value);
                destinationField.set(destination, value);

            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
