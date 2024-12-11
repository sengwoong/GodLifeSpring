package com.example.GodLife.service;
import com.example.GodLife.Repository.PostRepository;
import com.example.GodLife.Repository.UserRepository;
import com.example.GodLife.module.Post;
import com.example.GodLife.module.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Post createPost(Long userId, Post post) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));
        post.setUser(user);
        return postRepository.save(post);
    }

    public List<Post> getPostsByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    public void deletePost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + postId));
        postRepository.delete(post);
    }
}
