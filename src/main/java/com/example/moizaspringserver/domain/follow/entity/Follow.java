package com.example.moizaspringserver.domain.follow.entity;

import com.example.moizaspringserver.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "tbl_follow")
public class Follow extends BaseTimeEntity {

    @EmbeddedId
    private FollowId id;

}
