# Permutation & Combination Calculator API - Ruby Gem

Calculate permutations (P(n,r)) and combinations (C(n,r)) for any given values of n and r.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_permutationcombination'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_permutationcombination
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_permutationcombination'

# Initialize the client
client = APIVerve::Permutationcombination::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  n: 10,
  r: 3
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ n: 10, r: 3 })
  puts response["data"]
rescue APIVerve::Permutationcombination::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Permutationcombination::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Permutationcombination::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/permutationcombination?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/permutationcombination?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/permutationcombination?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
