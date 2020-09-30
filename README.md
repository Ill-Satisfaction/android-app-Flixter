# Flix
Flix is an app that allows users to browse movies from the [The Movie Database API](http://docs.themoviedb.apiary.io/#).

📝 `NOTE - PART 2 will be posted here when completed

---

## Flix Part 1

### User Stories

#### REQUIRED (10pts)
- [x] (10pts) User can view a list of movies (title, poster image, and overview) currently playing in theaters from the Movie Database API.

#### BONUS
- [x] (2pts) Views should be responsive for both landscape/portrait mode.
   - [x] (1pt) In portrait mode, the poster image, title, and movie overview is shown.
   - [x] (1pt) In landscape mode, the rotated alternate layout should use the backdrop image instead and show the title and movie overview to the right of it.

- [ ] (2pts) Display a nice default [placeholder graphic](https://guides.codepath.org/android/Displaying-Images-with-the-Glide-Library#advanced-usage) for each image during loading
- [ ] (2pts) Improved the user interface by experimenting with styling and coloring.
- [x] (2pts) For popular movies (i.e. a movie voted for more than 5 stars), the full backdrop image is displayed. Otherwise, a poster image, the movie title, and overview is listed. Use Heterogenous RecyclerViews and use different ViewHolder layout files for popular movies and less popular ones.

### App Walkthough GIF

<img src="https://github.com/Ill-Satisfaction/Ill_Satisfaction_Flixster/blob/master/flixster_walkthrough_I.gif" width=250><br>

GIF created with [LiceCap](http://www.cockos.com/licecap/).

### Notes
- I hit a snag early on when I got a ```androidx.constraintlayout.widget.ConstraintLayout``` error on the line ```AsyncHttpClient client = new AsyncHttpClient();```. I found the solution in the CodePath discussion board and did not need to form my own question. I was using the wrong SDK version. 

- I had some difficulties figuring out how to access the orientation of the device inside the movie class. In the end I required context to be passed in to determine which image to grab. I figure I'll need that anyways when I make the image size responsive.

### Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Androids
