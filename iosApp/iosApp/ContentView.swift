import SwiftUI
import shared

struct ContentView: View {
    let postService = PostService()
    
    @State var posts = "Loading..."
    
    func load() {
        postService.getPosts { result, error in
            if let result = result {
                self.posts = result
                postService.close()
            } else if let error = error {
                posts = "Error: \(error)"
                postService.close()
            }
        }
    }
    
    var body: some View {
        Text(posts).onAppear() {
            load()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
