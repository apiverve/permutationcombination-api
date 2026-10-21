# Permutation & Combination Calculator API - PHP Package

Calculate permutations (P(n,r)) and combinations (C(n,r)) for any given values of n and r.

## Installation

Install via Composer:

```bash
composer require apiverve/permutationcombination
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Permutationcombination\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'n' => 10,
    'r' => 3
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Permutationcombination\Client;
use APIVerve\Permutationcombination\Exceptions\APIException;
use APIVerve\Permutationcombination\Exceptions\ValidationException;

try {
    $response = $client->execute(['n' => 10, 'r' => 3]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "n": 10,
    "r": 3,
    "permutation": 720,
    "combination": 120,
    "formulas": {
      "permutation": "P(n,r) = n! / (n-r)!",
      "combination": "C(n,r) = n! / (r! × (n-r)!)"
    }
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/permutationcombination?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/permutationcombination?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/permutationcombination?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
