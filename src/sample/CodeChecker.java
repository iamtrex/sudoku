package sample;

import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CodeChecker {

    String[] allowed = {"1","2","3","4","5","6","7","8","9", ""};

    public boolean isAllowed(String e){
        for(String s : allowed){
            if(s.equals(e)){
                return true;
            }
        }
        return false;
    }

}
