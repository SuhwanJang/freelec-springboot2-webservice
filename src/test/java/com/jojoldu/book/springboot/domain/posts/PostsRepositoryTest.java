package com.jojoldu.book.springboot.domain.posts;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PostsRepositoryTest {

  @Autowired
  PostsRepository postsRepository;

  @AfterEach
  public void cleanUp() {
    postsRepository.deleteAll();
  }

  @Test
  public void loadPost() {
    String title = "test";
    String content = "content";

    postsRepository.save(Posts.builder().title(title).content(content).author("jsh").build());

    List<Posts> postsList = postsRepository.findAll();

    Posts posts = postsList.get(0);
    assertThat(posts.getTitle()).isEqualTo(title);
    assertThat(posts.getContent()).isEqualTo(content);
  }
}