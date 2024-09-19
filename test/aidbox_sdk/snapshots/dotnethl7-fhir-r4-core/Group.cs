using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class Group : DomainResource, IResource
{
    public string? Name { get; set; }
    public required string Type { get; set; }
    public Group_Member[]? Member { get; set; }
    public Group_Characteristic[]? Characteristic { get; set; }
    public bool? Active { get; set; }
    public Base.CodeableConcept? Code { get; set; }
    public Base.Identifier[]? Identifier { get; set; }
    public uint? Quantity { get; set; }
    public Base.ResourceReference? ManagingEntity { get; set; }
    public required bool Actual { get; set; }

    public class Group_Member : BackboneElement
    {
        public required Base.ResourceReference Entity { get; set; }
        public Base.Period? Period { get; set; }
        public bool? Inactive { get; set; }
    }

    public class Group_Characteristic : BackboneElement
    {
        public required bool Exclude { get; set; }
        public Base.ResourceReference? ValueReference { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueCodeableConcept is not null)
                {
                    return ValueCodeableConcept;
                }
        
                if (ValueRange is not null)
                {
                    return ValueRange;
                }
        
                return null;
            }
        
            set
            {
                if (value?.GetType() == typeof(Base.ResourceReference))
                {
                    ValueReference = (Base.ResourceReference)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;
                    return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.CodeableConcept))
                {
                    ValueCodeableConcept = (Base.CodeableConcept)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Range))
                {
                    ValueRange = (Base.Range)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public bool? ValueBoolean { get; set; }
        public required Base.CodeableConcept Code { get; set; }
        public Base.CodeableConcept? ValueCodeableConcept { get; set; }
        public Base.Period? Period { get; set; }
        public Base.Range? ValueRange { get; set; }
    }
}