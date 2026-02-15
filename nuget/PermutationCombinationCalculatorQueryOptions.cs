using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.PermutationCombinationCalculator
{
    /// <summary>
    /// Query options for the Permutation & Combination Calculator API
    /// </summary>
    public class PermutationCombinationCalculatorQueryOptions
    {
        /// <summary>
        /// Total number of items
        /// </summary>
        [JsonProperty("n")]
        public string N { get; set; }

        /// <summary>
        /// Number of items to choose (must be <= n)
        /// </summary>
        [JsonProperty("r")]
        public string R { get; set; }
    }
}
