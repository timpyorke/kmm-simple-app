//
//  PostListViewModel.swift
//  iosApp
//
//  Created by Thongphitak Sowanna on 28/4/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//
import Combine
import Foundation
import shared

class PostListViewModel : ObservableObject {
    
    @Published var posts = [Post]()
    
    let postRepository: PostRepository = PostRepositoryImpl(postService: PostService())
    
    func fatchPost() {
        postRepository.getPosts { posts, _ in
            if let result = posts {
                self.posts = result
            }
        }
    }
}
