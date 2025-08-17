package com.mybatis.mybatis_demo.dao;

import com.mybatis.mybatis_demo.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM BOOKS") //SQL
    List<Book> findAll( );

    @Select("SELECT * FROM BOOKS WHERE GENRE = #{genre}")
    List<Book> findByGenre(@Param("genre") String genre);

    @Select("{CALL GET_BOOKS_BY_PUBLISHER(#{publisherName, mode=IN, jdbcType=VARCHAR})}")
    @Results({
            @Result(property = "title", column = "TITLE"),
            @Result(property = "authorFirstName", column = "AUTHOR_FIRST_NAME"),
            @Result(property = "authorLastName", column = "AUTHOR_LAST_NAME"),
            @Result(property = "price", column = "PRICE")
    })
    List<Book> getBooksByPublisher(@Param("publisherName") String publisherName);

//  CREATE TABLE IF NOT EXISTS BOOKS (
//      ID                  INT          NOT NULL  AUTO_INCREMENT PRIMARY KEY
//      ,ISBN               VARCHAR(13)  NOT NULL  CONSTRAINT books_isbn_uc UNIQUE
//  ,AUTHOR_FIRST_NAME  VARCHAR(255) NOT NULL
//  ,AUTHOR_LAST_NAME   VARCHAR(255) NOT NULL
//  ,TITLE              VARCHAR(255) NOT NULL
//  ,DESCRIPTION        VARCHAR(750) NOT NULL
//  ,GENRE	            VARCHAR(255) NOT NULL
//  ,PRICE              DOUBLE       NOT NULL
//  ,PUBLISHER          VARCHAR(255)
//  ,PUBLISHED_ON       DATE );

//  public class Book {
//    private Integer id;
//    private String isbn;
//    private String title;
//    private String description;
//    private String authorFirstName;
//    private String authorLastName;
//    private String genre;
//    private double price;
//    ...
}
