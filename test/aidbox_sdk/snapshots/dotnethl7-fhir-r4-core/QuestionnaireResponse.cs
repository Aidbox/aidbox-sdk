using Aidbox.FHIR.Base;
using Aidbox.FHIR.Utils;

namespace Aidbox.FHIR.R4.Core;

public class QuestionnaireResponse : DomainResource, IResource
{
    public string? Questionnaire { get; set; }
    public Base.ResourceReference? Encounter { get; set; }
    public QuestionnaireResponse_Item[]? Item { get; set; }
    public Base.ResourceReference? Source { get; set; }
    public Base.ResourceReference? Author { get; set; }
    public required string Status { get; set; }
    public Base.Identifier? Identifier { get; set; }
    public Base.ResourceReference[]? BasedOn { get; set; }
    public string? Authored { get; set; }
    public Base.ResourceReference[]? PartOf { get; set; }
    public Base.ResourceReference? Subject { get; set; }

    public class QuestionnaireResponse_Item_Answer : BackboneElement
    {
        public Base.ResourceReference? ValueReference { get; set; }
        public string? ValueUri { get; set; }
        public string? ValueTime { get; set; }
        public string? ValueDecimal { get; set; }
        public Base.Quantity? ValueQuantity { get; set; }
        public object? Value    
        {
            get
            {
                if (ValueReference is not null)
                {
                    return ValueReference;
                }
        
                if (ValueUri is not null)
                {
                    return ValueUri;
                }
        
                if (ValueTime is not null)
                {
                    return ValueTime;
                }
        
                if (ValueDecimal is not null)
                {
                    return ValueDecimal;
                }
        
                if (ValueQuantity is not null)
                {
                    return ValueQuantity;
                }
        
                if (ValueString is not null)
                {
                    return ValueString;
                }
        
                if (ValueBoolean is not null)
                {
                    return ValueBoolean;
                }
        
                if (ValueDateTime is not null)
                {
                    return ValueDateTime;
                }
        
                if (ValueDate is not null)
                {
                    return ValueDate;
                }
        
                if (ValueCoding is not null)
                {
                    return ValueCoding;
                }
        
                if (ValueInteger is not null)
                {
                    return ValueInteger;
                }
        
                if (ValueAttachment is not null)
                {
                    return ValueAttachment;
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
        
                if (value?.GetType() == typeof(string))
                {
                    ValueUri = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueTime = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDecimal = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Quantity))
                {
                    ValueQuantity = (Base.Quantity)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueString = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(bool))
                {
                    ValueBoolean = (bool)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDateTime = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(string))
                {
                    ValueDate = (string)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Coding))
                {
                    ValueCoding = (Base.Coding)value;
                    return;
                }
        
                if (value?.GetType() == typeof(int))
                {
                    ValueInteger = (int)value;
                    return;
                }
        
                if (value?.GetType() == typeof(Base.Attachment))
                {
                    ValueAttachment = (Base.Attachment)value;
                    return;
                }
        
                throw new ArgumentException("Invalid type provided");
            }
        }
        public Base.ResourceReference[]? Item { get; set; }
        public string? ValueString { get; set; }
        public bool? ValueBoolean { get; set; }
        public string? ValueDateTime { get; set; }
        public string? ValueDate { get; set; }
        public Base.Coding? ValueCoding { get; set; }
        public int? ValueInteger { get; set; }
        public Base.Attachment? ValueAttachment { get; set; }
    }

    public class QuestionnaireResponse_Item : BackboneElement
    {
        public Base.ResourceReference[]? Item { get; set; }
        public string? Text { get; set; }
        public QuestionnaireResponse_Item_Answer[]? Answer { get; set; }
        public required string LinkId { get; set; }
        public string? Definition { get; set; }
    }
}