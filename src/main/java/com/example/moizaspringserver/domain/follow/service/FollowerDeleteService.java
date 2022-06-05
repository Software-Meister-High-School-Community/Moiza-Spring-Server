package com.example.moizaspringserver.domain.follow.service;

import com.example.moizaspringserver.domain.follow.entity.Follow;
import com.example.moizaspringserver.domain.follow.exception.NoSuchFollowerException;
import com.example.moizaspringserver.domain.follow.repository.FollowRepository;
import com.example.moizaspringserver.domain.user.entity.User;
import com.example.moizaspringserver.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FollowerDeleteService {
    private final UserFacade userFacade;
    private final FollowRepository followRepository;

    @Transactional
    public void execute(int followerIdToDelete) {
        User queryUser = userFacade.queryCurrentUser();
        User followerToDelete = userFacade.queryUserById(followerIdToDelete);

        Follow followerRelation = followRepository.findByUserAndTargetUser(followerToDelete, queryUser)
                .orElseThrow(() -> NoSuchFollowerException.EXCEPTION);

        followRepository.delete(followerRelation);
    }
}
