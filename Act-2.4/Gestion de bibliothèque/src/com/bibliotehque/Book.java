package com.bibliotehque;

public class Book implements BUR {
    private int id;
    private String title;
    private String author;
    private String editor;
    private int pageNb;
    private String summary;
    private Library library;

    public Book() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getPageNb() {
        return pageNb;
    }

    public void setPageNb(int pageNb) {
        this.pageNb = pageNb;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public void display() {
        System.out.println("Titre: " + getTitle());
        System.out.println("Auteur: " + getAuthor());
        System.out.println("Edité par: " + getEditor());
        System.out.println("Nombres de pages: " + getPageNb());
        System.out.println("Librairie: " + getLibrary());
        System.out.println("Résumé: " + getSummary());
    }

}
