using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class CoverageEligibilityRequest : DomainResource, IResource
{
    public required Base.ResourceReference Patient { get; set; }
    public CoverageEligibilityRequest_Insurance[]? Insurance { get; set; }
    public Base.ResourceReference? Facility { get; set; }
    public Base.ResourceReference? Enterer { get; set; }
    public CoverageEligibilityRequest_SupportingInfo[]? SupportingInfo { get; set; }
    public required string[] Purpose { get; set; }
    public CoverageEligibilityRequest_Item[]? Item { get; set; }
    public required string Created { get; set; }
    public object? Serviced    
    {
        get
        {
            if (ServicedDate is not null)
            {
                return ServicedDate;
            }
    
            if (ServicedPeriod is not null)
            {
                return ServicedPeriod;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                ServicedDate = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.Period))
            {
                ServicedPeriod = (Base.Period)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public required Base.ResourceReference Insurer { get; set; }
    public Base.CodeableConcept? Priority { get; set; }
    public required string Status { get; set; }
    public string? ServicedDate { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference? Provider { get; set; }
    public Base.Period? ServicedPeriod { get; set; }

    public class CoverageEligibilityRequest_Insurance : BackboneElement
    {
        public bool? Focal { get; set; }
        public required Base.ResourceReference Coverage { get; set; }
        public string? BusinessArrangement { get; set; }
    }

    public class CoverageEligibilityRequest_SupportingInfo : BackboneElement
    {
        public required string Sequence { get; set; }
        public required Base.ResourceReference Information { get; set; }
        public bool? AppliesToAll { get; set; }
    }

    public class CoverageEligibilityRequest_Item_Diagnosis : BackboneElement
    {
        public object? Diagnosis    
        {
            get
            {
                if (DiagnosisReference is not null)
                {
                    return DiagnosisReference;
                }
        
                if (DiagnosisCodeableConcept is not null)
                {
                    return DiagnosisCodeableConcept;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    DiagnosisReference = (Base.ResourceReference)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DiagnosisCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference? DiagnosisReference { get; set; }
        public Base.CodeableConcept? DiagnosisCodeableConcept { get; set; }
    }

    public class CoverageEligibilityRequest_Item : BackboneElement
    {
        public Base.CodeableConcept? Category { get; set; }
        public Base.ResourceReference? Facility { get; set; }
        public CoverageEligibilityRequest_Item_Diagnosis[]? Diagnosis { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept? ProductOrService { get; set; }
        public Base.Quantity? Quantity { get; set; }
        public Base.ResourceReference? Provider { get; set; }
        public string[]? SupportingInfoSequence { get; set; }
        public Base.Money? UnitPrice { get; set; }
        public Base.ResourceReference[]? Detail { get; set; }
    }
}