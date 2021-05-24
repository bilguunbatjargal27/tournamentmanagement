package com.bingu.tournamentmanager.service.impl;

import com.bingu.tournamentmanager.model.Tag;
import com.bingu.tournamentmanager.repository.TagRepository;
import com.bingu.tournamentmanager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag findTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<Tag> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Collection<Tag> saveTags(List<Tag> tags) {
        return tagRepository.saveAll(tags);
    }

}
