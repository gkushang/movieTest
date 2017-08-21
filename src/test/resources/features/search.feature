Feature: Search the movie

  @count_movies
  Scenario: Fred counts the movies

    Given Fred creates the library with 100 movies
    When he counts total number of movies
    Then he gets 100 count
