/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student.results.management.modal;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lakmal
 */
public class Department extends Modal{
    private final String[] schema = {"id", "name"};

    public Department() {
        super("department");
        super.setSchema(schema);
    }
    
    @Override
    public ResultSet select(String[] columns) throws SQLException {
        return super.select(columns);
    }
    
    @Override
    public ResultSet select(String[] columns, int limit) throws SQLException {
        return super.select(columns, limit);
    }
    
    @Override
    public ResultSet selectAll() throws SQLException{
        return super.selectAll();
    }
    
    @Override
    public int create(String columns[]) throws Exception {
        return super.create(columns);
    }
    
    @Override
    public boolean delete(String value) throws SQLException {
        return super.delete(value);
    }
    
    public int update(int id, String name) throws Exception {
        return super.update("UPDATE department SET name = '" + name + "' WHERE id = " + id);
    }
}
