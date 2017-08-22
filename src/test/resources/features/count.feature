Feature: Count the movie

  @count_movies @wip
  Scenario: Fred counts the movies

    Given Fred creates the library with 1001 movies
    When he counts total number of movies
    Then he gets 1001 count

  @count_all_movies
  Scenario: Fred counts all the movies

    Given Fred creates the library with 1001 movies
    When he counts total number of movies
    Then he gets 1001 count
