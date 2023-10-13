Feature: swag lab e-commerce application

  Background: Open browser
    Given launch browser

  @tag2
  Scenario: validate user interface header and footers  in
    And validate header
    And validate body
    Then validate footers

  @tag3
  Scenario Outline: Login with all users
    And login with all user <username>,<password>

    Examples: 
      | username                  | password       |
      | "standard_user"           | "secret_sauce" |
      | "locked_out_user"         | "secret_sauce" |
      | "problem_user"            | "secret_sauce" |
      | "performance_glitch_user" | "secret_sauce" |

  @tag4
  Scenario Outline: validate user interface header and footer in inventory page
    And do login <username>, <password>
    And validate inventory page header
    And validate inventory page body
    Then validate inventory pag footers

    Examples: 
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  @tag5
  Scenario Outline: validate sorting logic for name and price
    When user login <username>, <password>
    Then validate the sorting logic for name and price

    Examples: 
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  @tag6
  Scenario Outline: Add product to the cart
    When user login <username>, <password>
    And user add the product to the cart

    Examples: 
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  @tag7
  Scenario Outline: validate one is showing near shopping cart
    When user login <username>, <password>
    And user add the product to the cart
    Then user validate the count <count> is showing near shopping cart

    Examples: 
      | username       | password       | count |
      | "standard_user" | "secret_sauce" | "1"   |

  @tag8
  Scenario Outline: vaidate userinterface headers and footers
    When user login <username>, <password>
    Then validate the user interface headers  and footers

    Examples: 
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  @tag9
  Scenario Outline: Add two more product and validate the count of the product
    When user login <username>, <password>
    Then Add two more product

    Examples: 
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  @tag10
  Scenario Outline: Try to remove one product
    When user login <username>, <password>
    And user removes one product

    Examples: 
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  @tag11
  Scenario Outline: Store product detail in excel sheet
    When user login <username>, <password>
    And Add product details to the excel

    Examples: 
      | username        | password       |
      | "standard_user" | "secret_sauce" |

  @tag12
  Scenario Outline: Validate userinteface in checkout page
    When user login <username>, <password>
    Then validate headers in checkoutpage <header>, <secheader>
    And Validate body in checkout page <firstname>,<lastname>,<zip>
    Then validate footers in checkoutpage

    Examples: 
      | username        | password       | header      | secheader                    | firstname    | lastname    | zip               |
      | "standard_user" | "secret_sauce" | "Swag Labs" | "Checkout: Your Information" | "First Name" | "Last Name" | "Zip/Postal Code" |
