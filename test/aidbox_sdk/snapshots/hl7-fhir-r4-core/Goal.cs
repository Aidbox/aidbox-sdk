using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.Resource;

public class Goal : DomainResource, IResource
{
    public required Base.CodeableConcept Description { get; set; }
    public Base.CodeableConcept[]? Category { get; set; }
    public Base.ResourceReference[]? Addresses { get; set; }
    public Base.ResourceReference? ExpressedBy { get; set; }
    public string? StartDate { get; set; }
    public object? Start    
    {
        get
        {
            if (StartDate is not null)
            {
                return StartDate;
            }
    
            if (StartCodeableConcept is not null)
            {
                return StartCodeableConcept;
            }
    
            return null;
        }
    
        set
        {
            if (value?.GetType() == typeof(string))
            {
                StartDate = (string)value;return;
            }
    
            if (value?.GetType() == typeof(Base.CodeableConcept))
            {
                StartCodeableConcept = (Base.CodeableConcept)value;return;
            }
    
            throw new ArgumentException("Invalid type provided");
        }
    }
    public Base.CodeableConcept? AchievementStatus { get; set; }
    public string? StatusReason { get; set; }
    public Base.Annotation[]? Note { get; set; }
    public Base.CodeableConcept? StartCodeableConcept { get; set; }
    public Base.CodeableConcept? Priority { get; set; }
    public Base.CodeableConcept[]? OutcomeCode { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public string? StatusDate { get; set; }
    public Goal_Target[]? Target { get; set; }
    public Base.ResourceReference[]? OutcomeReference { get; set; }
    public required Base.ResourceReference Subject { get; set; }
    public required string LifecycleStatus { get; set; }

    public class Goal_Target : BackboneElement
    {
        public Base.Range? DetailRange { get; set; }
        public Base.Quantity? DetailQuantity { get; set; }
        public int? DetailInteger { get; set; }
        public string? DetailString { get; set; }
        public Base.CodeableConcept? Measure { get; set; }
        public object? Due    
        {
            get
            {
                if (DueDate is not null)
                {
                    return DueDate;
                }
        
                if (DueDuration is not null)
                {
                    return DueDuration;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(string))
                {
                    DueDate = (string)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DueDuration = (string)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.Ratio? DetailRatio { get; set; }
        public Base.CodeableConcept? DetailCodeableConcept { get; set; }
        public string? DueDate { get; set; }
        public bool? DetailBoolean { get; set; }
        public string? DueDuration { get; set; }
        public object? Detail    
        {
            get
            {
                if (DetailRange is not null)
                {
                    return DetailRange;
                }
        
                if (DetailQuantity is not null)
                {
                    return DetailQuantity;
                }
        
                if (DetailInteger is not null)
                {
                    return DetailInteger;
                }
        
                if (DetailString is not null)
                {
                    return DetailString;
                }
        
                if (DetailRatio is not null)
                {
                    return DetailRatio;
                }
        
                if (DetailCodeableConcept is not null)
                {
                    return DetailCodeableConcept;
                }
        
                if (DetailBoolean is not null)
                {
                    return DetailBoolean;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.Range))
                {
                    DetailRange = (Base.Range)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    DetailQuantity = (Base.Quantity)value;return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    DetailInteger = (int)value;return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    DetailString = (string)value;return;
                }
        
                if (value?.GetType() == typeof(Base.Ratio))
                {
                    DetailRatio = (Base.Ratio)value;return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    DetailCodeableConcept = (Base.CodeableConcept)value;return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    DetailBoolean = (bool)value;return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
    }
}