package DAO;

import com.sun.xml.internal.stream.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.function.Function;

public class ResultSetIterator<T> implements Iterator<T> {
    private Function <ResultSet,T> transform;
    private ResultSet entities;
    private boolean didNext = false;
    private boolean hasNext = false;


   public ResultSetIterator(ResultSet entities, Function <ResultSet,T> transform){
       this.entities=entities;
       this.transform =transform;
    }


    @Override
    public boolean hasNext() {
        if (!didNext) {
            try {
                hasNext = entities.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            didNext = true;
        }
        return hasNext;
    }

    @Override
    public T next() {
        if (!didNext) {
            try {
                entities.next();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        didNext = false;

        return  transform.apply(entities);

    }



}







//rowmapper