Feature: Count the movie

  @count_movies
  Scenario: Fred counts the movies

    Given Fred creates the library with 1000 movies
    When he counts total number of movies
    Then he gets 1000 count

  @count_all_movies
  Scenario: Fred counts all the movies

    Given Fred creates the library with 1000 movies
    When he counts total number of movies
    Then he gets 1000 count
