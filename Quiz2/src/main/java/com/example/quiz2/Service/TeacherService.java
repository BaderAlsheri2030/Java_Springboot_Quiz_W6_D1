package com.example.quiz2.Service;

import com.example.quiz2.Model.Teacher;
import com.sun.source.tree.BreakTree;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers =new ArrayList<>();

    public ArrayList<Teacher> getTeachers(){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean deleteTeacher(String id){
        for (int i = 0; i <teachers.size() ; i++) {
            if (teachers.get(i).getId().equals(id)){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean updateTeacher(String id, Teacher teacher){
        for (int i = 0; i <teachers.size() ; i++) {
            if (teachers.get(i).getId().equals(id)){
                teachers.set(i,teacher);
                return true;
            }
        }
        return false;
    }

    public Teacher getOneTeacher(String id){
        for (Teacher teacher:teachers) {
            if (teacher.getId().equals(id)){
                return teacher;
            }
        }
        return null;
    }
}
