//
//  PostList.swift
//  iosApp
//
//  Created by Thongphitak Sowanna on 27/4/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI
import shared
import Combine

struct PostList: View {
    
    @ObservedObject var viewModel = PostListViewModel()
    
    var body: some View {
        NavigationView {
            List(viewModel.posts, id: \.self.id) { post in
                NavigationLink {
                    PostDetail(post: post)
                } label: {
                    PostItem(post: post)
                }
            }
            .navigationTitle("Post List").onAppear {
                viewModel.fatchPost()
            }
        }
    }
}

struct PostItem: View {
    
    var post: Post
    
    var body: some View {
        VStack {
            Text(post.title).bold()
            Text(post.body)
            Spacer()
        }
    }
}
