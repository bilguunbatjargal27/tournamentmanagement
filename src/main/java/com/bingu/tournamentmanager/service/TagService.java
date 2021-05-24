package com.bingu.tournamentmanager.service;


import com.bingu.tournamentmanager.model.Tag;

import java.util.Collection;
import java.util.List;

public interface TagService {

    Tag saveTag(Tag tag);
    void deleteTag(Long id);
    Tag findTagById(Long id);
    Collection<Tag> findAll();
    Collection<Tag> saveTags(List<Tag> tags);

}
