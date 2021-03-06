Feature: Search the movie

  @search_multiple_movies
  Scenario Outline: Fred searches for the movie

    Given movie library has 3 entries of "<name>" movie
    When Fred searches for the "<name>" movie
    Then he gets "<count>" movies only

    Examples:
      | name    | count |
      | Avon    | 3     |
      | connect | 3     |


  @search_one_movie
  Scenario: Fred searches for the movie

    Given movie library has 1 entries of "Sultan" movie
    When Fred searches for the "Sultan" movie
    Then he gets "1" movies from search
