using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class MedicinalProductAuthorization : DomainResource, IResource
{
    public Base.Period? DataExclusivityPeriod { get; set; }
    public string? RestoreDate { get; set; }
    public Base.CodeableConcept[]? Jurisdiction { get; set; }
    public MedicinalProductAuthorization_JurisdictionalAuthorization[]? JurisdictionalAuthorization { get; set; }
    public MedicinalProductAuthorization_Procedure? Procedure { get; set; }
    public Base.CodeableConcept? LegalBasis { get; set; }
    public Base.Period? ValidityPeriod { get; set; }
    public Base.ResourceReference? Regulator { get; set; }
    public Base.CodeableConcept? Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? StatusDate { get; set; }
    public string? DateOfFirstAuthorization { get; set; }
    public string? InternationalBirthDate { get; set; }
    public Base.ResourceReference? Holder { get; set; }
    public Base.CodeableConcept[]? Country { get; set; }
    public Base.ResourceReference? Subject { get; set; }

    public class MedicinalProductAuthorization_JurisdictionalAuthorization : BackboneElement
    {
        public Base.CodeableConcept? Country { get; set; }
        public Base.Identifier[]? Identifier { get; set; }
        public Base.CodeableConcept[]? Jurisdiction { get; set; }
        public Base.Period? ValidityPeriod { get; set; }
        public Base.CodeableConcept? LegalStatusOfSupply { get; set; }
    }

    public class MedicinalProductAuthorization_Procedure : BackboneElement
    {
        public object? Date    
        {
            get
            {
                if (DatePeriod is not null)
                {
                    return DatePeriod;
                }
        
                if (DateDateTime is not null)
                {
                    return DateDateTime;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Period))
                {
                    DatePeriod = (Base.Period)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DateDateTime = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public required Base.CodeableConcept Type { get; set; }
        public Base.Period? DatePeriod { get; set; }
        public Base.Identifier? Identifier { get; set; }
        public Base.ResourceReference[]? Application { get; set; }
        public string? DateDateTime { get; set; }
    }
}