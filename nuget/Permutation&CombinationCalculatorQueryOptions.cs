using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.Permutation&CombinationCalculator
{
    /// <summary>
    /// Query options for the Permutation & Combination Calculator API
    /// </summary>
    public class Permutation&CombinationCalculatorQueryOptions
    {
        /// <summary>
        /// Total number of items (0-170)
        /// Example: 10
        /// </summary>
        [JsonProperty("n")]
        public string N { get; set; }

        /// <summary>
        /// Number of items to choose (must be <= n)
        /// Example: 3
        /// </summary>
        [JsonProperty("r")]
        public string R { get; set; }
    }
}
