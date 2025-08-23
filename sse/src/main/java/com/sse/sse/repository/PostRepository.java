package com.sse.sse.repository;

import com.sse.sse.aggregate.Post;
import com.sse.sse.config.stream.MyObjectOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PostRepository {
    private static List<Post> posts;

    private final static File file = new File("src/main/java/com/sse/sse/db/post.dat");

    public PostRepository() {
        posts = new ArrayList<>();

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        loadPosts();
    }

    public void loadPosts() {
        try (ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))) {
            while (true) {
                posts.add((Post) ois.readObject());
            }
        } catch (EOFException e) {
//            System.out.println("===== 게시물 불러오기 성공 =====");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Long findLastPost() {
        return (posts.isEmpty()) ? -1 : posts.get(posts.size() - 1).getId();
    }

    public int registPost(Post post) {
        ObjectOutputStream oos = null;
        int result = 0;

        try {
            if (posts.isEmpty()) {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)));
            } else {
                oos = new MyObjectOutput(new BufferedOutputStream(new FileOutputStream(file, true)));
            }

            oos.writeObject(post);
            oos.flush();

            posts.clear();

            loadPosts();

            result = 1;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return result;
    }
}