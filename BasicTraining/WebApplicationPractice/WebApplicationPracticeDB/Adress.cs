using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WebApplicationPracticeDB
{
    public class Adress
    {
        [Key]
        public int AdressID { get; set; }
        public string Street { get; set; }
        public string AdressNumber { get; set; }
        public string PostalCode { get; set; }
        public string City { get; set; }
    }
}
