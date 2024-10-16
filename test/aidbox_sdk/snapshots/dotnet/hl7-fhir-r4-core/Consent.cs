using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Consent : DomainResource, IResource
{
    public Base.ResourceReference? Patient { get; set; }
    public required Base.CodeableConcept[] Category { get; set; }
    public Consent_Provision? Provision { get; set; }
    public Base.Attachment? SourceAttachment { get; set; }
    public Base.ResourceReference[]? Organization { get; set; }
    public Consent_Verification[]? Verification { get; set; }
    public object? Source    
    {
        get
        {
            if (SourceAttachment is not null)
            {
                return SourceAttachment;
            }
    
            if (SourceReference is not null)
            {
                return SourceReference;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(Base.Attachment))
            {
                SourceAttachment = (Base.Attachment)value;return;
            }
    
            if (value?.GetType() == typeof(Base.ResourceReference))
            {
                SourceReference = (Base.ResourceReference)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public required Base.CodeableConcept Scope { get; set; }
    public Consent_Policy[]? Policy { get; set; }
    public Base.ResourceReference? SourceReference { get; set; }
    public string? DateTime { get; set; }
    public required string Status { get; set; }
    public Base.CodeableConcept? PolicyRule { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public Base.ResourceReference[]? Performer { get; set; }

    public class Consent_Provision_Provision_Actor : BackboneElement
    {
        public required Base.CodeableConcept Role { get; set; }
        public required Base.ResourceReference Reference { get; set; }
    }

    public class Consent_Provision_Provision_Data : BackboneElement
    {
        public required string Meaning { get; set; }
        public required Base.ResourceReference Reference { get; set; }
    }

    public class Consent_Provision_Provision : BackboneElement
    {
        public string[]? Provision { get; set; }
        public Base.Coding[]? Purpose { get; set; }
        public Base.Period? DataPeriod { get; set; }
        public string? Type { get; set; }
        public Base.Coding[]? Class_ { get; set; }
        public Base.CodeableConcept[]? Code { get; set; }
        public Base.CodeableConcept[]? Action { get; set; }
        public Base.Period? Period { get; set; }
        public Base.Coding[]? SecurityLabel { get; set; }
        public Consent_Provision_Provision_Actor[]? Actor { get; set; }
        public Consent_Provision_Provision_Data[]? Data { get; set; }
    }

    public class Consent_Provision_Actor : BackboneElement
    {
        public required Base.CodeableConcept Role { get; set; }
        public required Base.ResourceReference Reference { get; set; }
    }

    public class Consent_Provision_Data : BackboneElement
    {
        public required string Meaning { get; set; }
        public required Base.ResourceReference Reference { get; set; }
    }

    public class Consent_Provision : BackboneElement
    {
        public Consent_Provision_Provision[]? Provision { get; set; }
        public Base.Coding[]? Purpose { get; set; }
        public Base.Period? DataPeriod { get; set; }
        public string? Type { get; set; }
        public Base.Coding[]? Class_ { get; set; }
        public Base.CodeableConcept[]? Code { get; set; }
        public Base.CodeableConcept[]? Action { get; set; }
        public Base.Period? Period { get; set; }
        public Base.Coding[]? SecurityLabel { get; set; }
        public Consent_Provision_Actor[]? Actor { get; set; }
        public Consent_Provision_Data[]? Data { get; set; }
    }

    public class Consent_Verification : BackboneElement
    {
        public required bool Verified { get; set; }
        public Base.ResourceReference? VerifiedWith { get; set; }
        public string? VerificationDate { get; set; }
    }

    public class Consent_Policy : BackboneElement
    {
        public string? Uri { get; set; }
        public string? Authority { get; set; }
    }
}