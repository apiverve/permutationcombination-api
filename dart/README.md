# Permutation & Combination Calculator API - Dart/Flutter Client

Calculate permutations (P(n,r)) and combinations (C(n,r)) for any given values of n and r.

[![pub package](https://img.shields.io/pub/v/apiverve_permutationcombination.svg)](https://pub.dev/packages/apiverve_permutationcombination)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Permutation & Combination Calculator API](https://apiverve.com/marketplace/permutationcombination?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_permutationcombination: ^1.2.5
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_permutationcombination/apiverve_permutationcombination.dart';

void main() async {
  final client = PermutationcombinationClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'n': 10,
      'r': 3
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Permutation & Combination Calculator API](https://apiverve.com/marketplace/permutationcombination?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/permutationcombination](https://docs.apiverve.com/ref/permutationcombination?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
