package main;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileHandler {

    FileHandler(){

    }

    public void saveToFile(List<Task> list_of_tasks, String file_name) {
        try {
            // Crée un répertoire temporaire pour les sauvegardes s'il n'existe pas déjà
            Path save_directory = Files.createDirectories(Paths.get(System.getProperty("user.home"), "\\Documents\\chalzSaves\\saves"));

            // Construit le chemin du fichier de sauvegarde
            Path save_file_path = save_directory.resolve(file_name + ".dat");

            // Écrit les données de la liste des tâches dans le fichier de sauvegarde
            try (ObjectOutputStream sortie = new ObjectOutputStream(new FileOutputStream(save_file_path.toFile()))) {
                sortie.writeObject(list_of_tasks);
            }

            System.out.println("Fichier de sauvegarde créé avec succès : " + save_file_path.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> listFilesInFolder(){
        List<String> file_names = new ArrayList<>();
        Path save_directory = null;
        try {
            save_directory = Files.createDirectories(Paths.get(System.getProperty("user.home"), "\\Documents\\chalzSaves\\saves"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File save_folder = new File(save_directory.toString());
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
        Path save_directory = null;
        try {
            save_directory = Files.createDirectories(Paths.get(System.getProperty("user.home"), "\\Documents\\chalzSaves\\saves"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            FileInputStream fichier = new FileInputStream(save_directory + "\\" + file_to_load +".dat");
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
