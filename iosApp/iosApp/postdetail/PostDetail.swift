//
//  PostDetail.swift
//  iosApp
//
//  Created by Thongphitak Sowanna on 27/4/2565 BE.
//  Copyright © 2565 BE orgName. All rights reserved.
//

import SwiftUI
import shared

struct PostDetail: View {
    var post: Post
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8){
            Text(Greeting().greeting())
            Text(post.title).bold()
            Text(post.body)
            Text("Author id :" + String(post.userId))
        }.padding()
    }
}
