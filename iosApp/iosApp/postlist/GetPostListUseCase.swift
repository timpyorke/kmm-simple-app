//
//  GetPostListUseCase.swift
//  iosApp
//
//  Created by Thongphitak Sowanna on 28/4/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import Combine
import Foundation
import shared

protocol GetPostListUseCase{
    func invoke()
}

struct GetPostListUseCaseImpl {
    
    let postRepository: PostRepository = PostRepositoryImpl(postService: PostService())
    
    func invoke() {
        postRepository.getPosts { value, e in
            
        }
    }
}
