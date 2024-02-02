import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileHandler {

    FileHandler(){

    }

    public void saveToFile(List<Task> list_of_tasks, String file_name) {
        String local_dir = System.getProperty("user.dir");
        try {
            FileOutputStream fichier = new FileOutputStream(local_dir + "\\..\\saves\\"+ file_name +".dat");
            ObjectOutputStream sortie = new ObjectOutputStream(fichier);
            sortie.writeObject(list_of_tasks);
            sortie.close();
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> listFilesInFolder(){
        List<String> file_names = new ArrayList<>();
        String local_dir = System.getProperty("user.dir");
        String save_folder_path = local_dir + "\\..\\saves";
        File save_folder = new File(save_folder_path);
        File[] save_files = save_folder.listFiles();
        for (int i = 0; i < Objects.requireNonNull(save_files).length; i++){
            if (save_files[i].isFile()) {
                file_names.add(save_files[i].getName().split("\\.")[0]);
            }
        }
        return file_names;
    }

    public List<Task> loadFromFile(String file_to_load) throws ClassNotFoundException {
        List<Task> list_input = new ArrayList<Task>();
        String local_dir = System.getProperty("user.dir");
        try {
            FileInputStream fichier = new FileInputStream(local_dir + "\\..\\saves\\"+file_to_load+".dat");
            ObjectInputStream entree = new ObjectInputStream(fichier);
            list_input = (List<Task>) entree.readObject();
            entree.close();
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list_input;
    }
}
