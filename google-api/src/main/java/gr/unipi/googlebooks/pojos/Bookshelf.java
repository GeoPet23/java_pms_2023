package gr.unipi.googlebooks.pojos;

import gr.unipi.googlebooks.search.enums.Access;

import java.util.Date;


/**
 * Base on https://developers.google.com/books/docs/v1/reference/bookshelves#resource
 * */
public class Bookshelf {
    public String kind;
    public int id;
    public String title;
    public Access access;
    public Date updated;
    public Date created;
    public int volumeCount;
    public Date volumesLastUpdated;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
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

    public Access getAccess() {
        return access;
    }

    public void setAccess(Access access) {
        this.access = access;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getVolumeCount() {
        return volumeCount;
    }

    public void setVolumeCount(int volumeCount) {
        this.volumeCount = volumeCount;
    }

    public Date getVolumesLastUpdated() {
        return volumesLastUpdated;
    }

    public void setVolumesLastUpdated(Date volumesLastUpdated) {
        this.volumesLastUpdated = volumesLastUpdated;
    }

    @Override
    public String toString() {
        return "Bookshelf{" +
                "kind='" + kind + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", access='" + access + '\'' +
                ", updated=" + updated +
                ", created=" + created +
                ", volumeCount=" + volumeCount +
                ", volumesLastUpdated=" + volumesLastUpdated +
                '}';
    }
}
