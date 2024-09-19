using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class CoverageEligibilityResponse : DomainResource, IResource
{
    public required Base.ResourceReference Patient { get; set; }
    public Base.ResourceReference? Requestor { get; set; }
    public CoverageEligibilityResponse_Insurance[]? Insurance { get; set; }
    public required Base.ResourceReference Request { get; set; }
    public string? PreAuthRef { get; set; }
    public required string[] Purpose { get; set; }
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
    public required string Outcome { get; set; }
    public string? Disposition { get; set; }
    public required Base.ResourceReference Insurer { get; set; }
    public required string Status { get; set; }
    public string? ServicedDate { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public CoverageEligibilityResponse_Error[]? Error { get; set; }
    public Base.CodeableConcept? Form { get; set; }
    public Base.Period? ServicedPeriod { get; set; }

    public class CoverageEligibilityResponse_Insurance_Item_Benefit : BackboneElement
    {
        public string? UsedString { get; set; }
        public Base.Money? AllowedMoney { get; set; }
        public required Base.CodeableConcept Type { get; set; }
        public uint? AllowedUnsignedInt { get; set; }
        public uint? UsedUnsignedInt { get; set; }
        public string? AllowedString { get; set; }
        public Base.Money? UsedMoney { get; set; }
        public object? Allowed    
        {
            get
            {
                if (AllowedMoney is not null)
                {
                    return AllowedMoney;
                }
        
                if (AllowedUnsignedInt is not null)
                {
                    return AllowedUnsignedInt;
                }
        
                if (AllowedString is not null)
                {
                    return AllowedString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Money))
                {
                    AllowedMoney = (Base.Money)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    AllowedUnsignedInt = (uint)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    AllowedString = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public object? Used    
        {
            get
            {
                if (UsedString is not null)
                {
                    return UsedString;
                }
        
                if (UsedUnsignedInt is not null)
                {
                    return UsedUnsignedInt;
                }
        
                if (UsedMoney is not null)
                {
                    return UsedMoney;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    UsedString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(uint))
                {
                    UsedUnsignedInt = (uint)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Money))
                {
                    UsedMoney = (Base.Money)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
    }

    public class CoverageEligibilityResponse_Insurance_Item : BackboneElement
    {
        public string? Description { get; set; }
        public Base.CodeableConcept? Category { get; set; }
        public bool? AuthorizationRequired { get; set; }
        public Base.CodeableConcept[]? Modifier { get; set; }
        public Base.CodeableConcept[]? AuthorizationSupporting { get; set; }
        public Base.CodeableConcept? Unit { get; set; }
        public bool? Excluded { get; set; }
        public string? Name { get; set; }
        public Base.CodeableConcept? ProductOrService { get; set; }
        public Base.CodeableConcept? Term { get; set; }
        public CoverageEligibilityResponse_Insurance_Item_Benefit[]? Benefit { get; set; }
        public string? AuthorizationUrl { get; set; }
        public Base.CodeableConcept? Network { get; set; }
        public Base.ResourceReference? Provider { get; set; }
    }

    public class CoverageEligibilityResponse_Insurance : BackboneElement
    {
        public CoverageEligibilityResponse_Insurance_Item[]? Item { get; set; }
        public bool? Inforce { get; set; }
        public required Base.ResourceReference Coverage { get; set; }
        public Base.Period? BenefitPeriod { get; set; }
    }

    public class CoverageEligibilityResponse_Error : BackboneElement
    {
        public required Base.CodeableConcept Code { get; set; }
    }
}