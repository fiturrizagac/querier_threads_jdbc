package com.gmc.devtest.om.entity;

/**
 * Created by BRIGETH on 13/02/2016.
 */
public class SampleEntity {

    private Long _id;
    private String _uuid;
    private String _area;
    private Long _idElection;

    public SampleEntity(final String uuid, final String area, final Long idElection) {
        _uuid = uuid;
        _area = area;
        _idElection = idElection;
    }

    public Long getId() {
        return _id;
    }

    public void setId(final Long id) {
        _id = id;
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(final String uuid) {
        _uuid = uuid;
    }

    public String getArea() {
        return _area;
    }

    public void setArea(final String area) {
        _area = area;
    }

    public Long getIdElection() {
        return _idElection;
    }

    public void setIdElection(final Long idElection) {
        _idElection = idElection;
    }
}
