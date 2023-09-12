Feature: Play Here Kitty Kitty
  The user can play Here Kitty Kitty
  Scenario: Press Play button and play the game
    Given User is in Here Kitty Kitty
    And the user's balance is 100
    When User press START button
    Then The game is started

  Scenario: Press plus button to change the bet
    Given User is in Here Kitty Kitty
    And the user's balance is 100
    When User press Plus button
    Then The bet have been raised


  Scenario: The balance of user is correct after he is played three reel games
    Given User is in Here Kitty Kitty
    And the user's balance is 100
    And user's bet is One pound
    When User is played three reel games
    Then The balance of user is three dollars less

  Scenario: User can play on Turbo Mode
    Given User is in Here Kitty Kitty
    And the user's balance is 100
    When User press TURBO button
    And press START button
    Then Reels are reeling faster than normal

  Scenario: User can play in AUTO Mode
    Given User is in Here Kitty Kitty
    And the user's balance is 100
    When User set auto mode for 10 games
    Then The game is played automated for 10 games without pressing START button each time