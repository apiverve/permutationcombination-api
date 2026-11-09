/// Response models for the Permutation & Combination Calculator API.

/// API Response wrapper.
class PermutationcombinationResponse {
  final String status;
  final dynamic error;
  final PermutationcombinationData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  PermutationcombinationResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory PermutationcombinationResponse.fromJson(Map<String, dynamic> json) => PermutationcombinationResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? PermutationcombinationData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Permutation & Combination Calculator API.

class PermutationcombinationData {
  num? n;
  num? r;
  num? permutation;
  num? combination;
  PermutationcombinationDataFormulas? formulas;

  PermutationcombinationData({
    this.n,
    this.r,
    this.permutation,
    this.combination,
    this.formulas,
  });

  factory PermutationcombinationData.fromJson(Map<String, dynamic> json) => PermutationcombinationData(
      n: json['n'],
      r: json['r'],
      permutation: json['permutation'],
      combination: json['combination'],
      formulas: json['formulas'] != null ? PermutationcombinationDataFormulas.fromJson(json['formulas']) : null,
    );
}

class PermutationcombinationDataFormulas {
  String? permutation;
  String? combination;

  PermutationcombinationDataFormulas({
    this.permutation,
    this.combination,
  });

  factory PermutationcombinationDataFormulas.fromJson(Map<String, dynamic> json) => PermutationcombinationDataFormulas(
      permutation: json['permutation'],
      combination: json['combination'],
    );
}

class PermutationcombinationRequest {
  int n;
  int r;

  PermutationcombinationRequest({
    required this.n,
    required this.r,
  });

  Map<String, dynamic> toJson() => {
      'n': n,
      'r': r,
    };
}
