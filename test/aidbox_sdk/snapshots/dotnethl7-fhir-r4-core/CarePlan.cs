using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class CarePlan : DomainResource, IResource
{
    public string? Description { get; set; }
    public Base.CodeableConcept[]? Category { get; set; }
    public Base.ResourceReference[]? Addresses { get; set; }
    public string[]? InstantiatesCanonical { get; set; }
    public string[]? InstantiatesUri { get; set; }
    public Base.ResourceReference[]? SupportingInfo { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public Base.ResourceReference[]? Goal { get; set; }
    public string? Created { get; set; }
    public string? Title { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.ResourceReference? Author { get; set; }
    public CarePlan_Activity[]? Activity { get; set; }
    public Base.ResourceReference[]? Contributor { get; set; }
    public required string Status { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public required string Intent { get; set; }
    public Base.ResourceReference[]? Replaces { get; set; }
    public Base.Period? Period { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public Base.ResourceReference[]? CareTeam { get; set; }

    public class CarePlan_Activity_Detail : BackboneElement
    {
        public string? Description { get; set; }
        public string[]? InstantiatesCanonical { get; set; }
        public string[]? InstantiatesUri { get; set; }
        public Base.CodeableConcept? ProductCodeableConcept { get; set; }
        public Base.ResourceReference? ProductReference { get; set; }
        public Base.Period? ScheduledPeriod { get; set; }
        public Base.ResourceReference[]? Goal { get; set; }
        public Base.CodeableConcept[]? ReasonCode { get; set; }
        public Base.CodeableConcept? StatusReason { get; set; }
        public string? ScheduledTiming { get; set; }
        public Base.Quantity? DailyAmount { get; set; }
        public object? Product    
        {
            get
            {
                if (ProductCodeableConcept is not null)
                {
                    return ProductCodeableConcept;
                }
        
                if (ProductReference is not null)
                {
                    return ProductReference;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ProductCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ProductReference = (Base.ResourceReference)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public string? ScheduledString { get; set; }
        public required string Status { get; set; }
        public string? Kind { get; set; }
        public Base.CodeableConcept? Code { get; set; }
        public bool? DoNotPerform { get; set; }
        public object? Scheduled    
        {
            get
            {
                if (ScheduledPeriod is not null)
                {
                    return ScheduledPeriod;
                }
        
                if (ScheduledTiming is not null)
                {
                    return ScheduledTiming;
                }
        
                if (ScheduledString is not null)
                {
                    return ScheduledString;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Period))
                {
                    ScheduledPeriod = (Base.Period)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ScheduledTiming = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ScheduledString = (string)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Quantity? Quantity { get; set; }
        public Base.ResourceReference? Location { get; set; }
        public Base.ResourceReference[]? Performer { get; set; }
        public Base.ResourceReference[]? ReasonReference { get; set; }
    }

    public class CarePlan_Activity : BackboneElement
    {
        public CarePlan_Activity_Detail? Detail { get; set; }
        public Base.Annotation[]? Progress { get; set; }
        public Base.ResourceReference? Reference { get; set; }
        public Base.ResourceReference[]? OutcomeReference { get; set; }
        public Base.CodeableConcept[]? OutcomeCodeableConcept { get; set; }
    }
}