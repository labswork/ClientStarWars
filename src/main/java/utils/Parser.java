package utils;

import models.People;

import java.io.File;

/**
 * Created by rootid on 28.03.2017.
 */
public interface Parser {
    People getObject(String filePath, Class c);
    void setObject(String file, Object o);
}
