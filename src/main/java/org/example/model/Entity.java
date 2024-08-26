package org.example.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface Entity {

    Entity constructFromResultSet(ResultSet rs) throws SQLException;

    PreparedStatement prepareStatement(PreparedStatement pstmt) throws SQLException;

    int getId();
}

